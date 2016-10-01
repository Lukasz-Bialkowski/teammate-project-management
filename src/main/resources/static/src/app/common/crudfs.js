// Crudfs base controller and service
function CrudfsSrv(baseUrl, cls, $resource) {
    this.operations = {
        list: {
            method: 'GET',
            isArray: true
        },
        get: {
            method: 'GET'
        },
        create: {
            method: 'POST',
            params: {
                operation: 'create'
            }
        },
        save: {
            method: 'POST',
            params: {
                operation: 'save'
            }
        },
        remove: {
            method: 'DELETE'
        },
        sortprops: {
            method: 'GET',
            isArray: true,
            params: {
                operation: 'sortprops'
            }
        },
        filter: {
            method: 'GET',
            isArray: true,
            params: {
                operation: 'filter'
            }
        }
    };

    this.getResource = function () {
        return $resource(baseUrl + cls + '/:id/:secId/:operation/:page', {}, this.operations);
    };
}

function CrudfsCtrl($scope, crudSrv, confirmSrv, rmMsg, noInit) {
    var removeMessage = rmMsg ? rmMsg : 'Czy na pewno chcesz usunąć wybrany element?';

    $scope.selected = null;
    $scope.current = null;
    $scope.currentPage = 1;

    $scope.pageSize = 10;
    $scope.sortProperty = {};
    $scope.filterResult = false;

    if (!noInit) {
        crudSrv.sortprops(function (response) {
            $scope.sortprops = response;
            for (var i = 0; i < $scope.sortprops.length; i++) {
                if ($scope.sortprops[i].def) {
                    $scope.sortProperty = $scope.sortprops[i];
                }
            }
        });

    }

    $scope.list = function () {
        var params = {
            currentPage: $scope.currentPage - 1,
            pageSize: $scope.pageSize
        };
        crudSrv.list(params, function (response) {
            $scope.currentPage = 1;
            $scope.data = response;
            $scope.filterResult = true;
            $scope.initialized = true;
            $scope.processPaging();
        });
    };

    $scope.sort = function (prop) {
        $scope.sortProperty = prop;

        var params = {
            filter: $scope.filterExp,
            property: $scope.sortProperty.property,
            direction: $scope.sortProperty.direction,
            currentPage: $scope.currentPage - 1,
            pageSize: $scope.pageSize
        };

        crudSrv.filter(params, $scope.onDataLoad);
    };

    $scope.filter = function () {
        var params = {
            filter: $scope.filterExp,
            property: $scope.sortProperty.property,
            direction: $scope.sortProperty.direction,
            currentPage: $scope.currentPage - 1,
            pageSize: $scope.pageSize
        };

        crudSrv.filter(params, $scope.onDataLoad);
    };

    $scope.select = function (item) {
        crudSrv.get({
            id: item.id
        }, function (response) {
            $scope.processSelect(item, response);
        });
    };

    $scope.processSelect = function (item, response) {
        $scope.selected = item;
        $scope.current = response;
    };

    $scope.create = function () {
        crudSrv.create(function (response) {
            $scope.processCreate(response);
        });
    };

    $scope.processCreate = function (response) {
        $scope.selected = null;
        $scope.current = response;
    };

    $scope.save = function (item) {
        crudSrv.save(item, function (response) {
            $scope.processSave(item, response);
        });
    };

    $scope.selectedIdx = function () {
        var selectedIndex = $scope.data.map(function (x) {
            return x.id;
        }).indexOf($scope.selected.id);
        return selectedIndex;
    };

    $scope.processSave = function (item, response) {
        if (item.id) {
            $scope.data[$scope.selectedIdx()] = item;
            $scope.selected = item;
            $scope.current = response;
        } else {
            $scope.selected = jQuery.extend(true, {}, response);
            $scope.data.push($scope.selected);
            $scope.current = response;
        }
        $scope.processPaging();
    };

    $scope.remove = function (item) {
        confirmSrv.confirm(function () {
            crudSrv.remove({
                id: item.id
            }, function (response) {
                $scope.processRemove(item);
                $scope.processPaging();
            }, function (response) {
            });
        }, removeMessage, 'Potwierdź usunięcie');
    };

    $scope.processRemove = function (item) {
        $scope.data.splice($scope.selectedIdx(), 1);
        $scope.selected = null;
        $scope.current = null;
    };

    $scope.cancel = function () {
        $scope.current = null;
    };

    $scope.resolveRowClass = function (item, selected) {
        if (selected === undefined) {
            if ($scope.selected != null && $scope.selected.id == item.id) {
                return 'success';
            }

            return null;

        } else if (selected != null && selected.id == item.id) {
            return 'success';
        }

        return null;
    };

    $scope.resolveSortPropClass = function (prop) {
        if (prop == $scope.sortProperty) {
            return 'text-primary';
        }
    };

    $scope.filterKeyPress = function ($event) {
        if ($event.keyCode == 13) {
            $event.preventDefault();
            $scope.filter();
        }
    };

    $scope.selectPage = function () {
        $scope.processPaging();
    };

    $scope.processPaging = function () {
        var begin = ($scope.currentPage - 1) * $scope.pageSize;
        var end = begin + $scope.pageSize;

        $scope.pagedData = $scope.data.slice(begin, end);
    };

    $scope.onDataLoad = function (response) {
        $scope.currentPage = 1;
        $scope.data = response;
        $scope.filterResult = true;
        $scope.initialized = true;
        $scope.processPaging();
    };

    Array.prototype.inArray = function (comparer) {
        for (var i = 0; i < this.length; i++) {
            if (comparer(this[i])) {
                return true;
            }
        }
        return false;
    };

    Array.prototype.pushIfNotExist = function (element, comparer) {
        if (!this.inArray(comparer)) {
            this.push(element);
        }
    };
}

// CrudfsPaging service
function CrudfsPagingSrv(baseUrl, $resource, cls) {
    CrudfsSrv.call(this, baseUrl, $resource, cls);

    this.operations.list = {
        method: 'GET',
        isArray: true,
        params: {
            page: 'paged'
        }
    };

    this.operations.filter = {
        method: 'GET',
        isArray: true,
        params: {
            operation: 'filter',
            page: 'paged'
        }
    };

    this.getResource = function () {
        return $resource(baseUrl + cls + '/:id/:operation/:page', {}, this.operations);
    };
}

// CrudfsPaging controller
function CrudfsPagingCtrl($scope, crudSrv, confirmSrv, rmMsg, noInit) {
    CrudfsCtrl.call(this, $scope, crudSrv, confirmSrv, rmMsg, noInit);

    // $scope.pageNumber = 1;

    $scope.processPaging = function () {
        // $scope.currentPage = $scope.pageNumber - 1;
        $scope.pagedData = $scope.data;
    };

    $scope.selectPage = function () {
        $scope.filter();
        $scope.processPaging();
    };

    $scope.onDataLoad = function (response, headers) {
        $scope.dataSize = headers('X-HRTools-Data-Size');
        $scope.data = response;
        $scope.filterResult = true;
        $scope.initialized = true;
        $scope.pagedData = response;
        $scope.processPaging();
    };
}
