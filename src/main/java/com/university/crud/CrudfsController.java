package com.university.crud;

public abstract class CrudfsController<T> extends CrudController<T> {

    public CrudfsController() {
    }

    protected abstract CrudfsService<T> getService();

//    @RequestMapping(value = {"/filter"}, method = {RequestMethod.GET})
//    @ResponseBody
//    public List<T> filter(@RequestParam(defaultValue = "") String filter, @RequestParam(required = false) String property,
//                          @RequestParam(defaultValue = "asc") String direction) {
//        String safeProperty = property == null?"id":property;
//        return this.getService().filter(filter, safeProperty, direction);
//    }
//
//    @RequestMapping(value = {"/sortprops"}, method = {RequestMethod.GET})
//    @ResponseBody
//    public List<SortProperty> getSortProperties() {
//        List sortProperties = this.getService().getSortProperties();
//        SortProperty defaultSortProperty = new SortProperty(this.getService().getDefaultSortProperty(), this.getService().getDefaultSortDirection());
//        ArrayList result = new ArrayList();
//        String[] dirs = new String[]{"ASC", "DESC"};
//        Iterator var5 = sortProperties.iterator();
//
//        while(var5.hasNext()) {
//            String property = (String)var5.next();
//            String[] var7 = dirs;
//            int var8 = dirs.length;
//
//            for(int var9 = 0; var9 < var8; ++var9) {
//                String dir = var7[var9];
//                StringBuilder keyName = new StringBuilder(this.getService().getCls().getName());
//                keyName.append(".sort.");
//                keyName.append(property);
//                keyName.append(".");
//                keyName.append(dir);
//                SortProperty sortProperty = new SortProperty(property, dir, this.translator.translate(keyName.toString(), LocaleContextHolder.getLocale(), true));
//                if(sortProperty.equals(defaultSortProperty)) {
//                    sortProperty.setDef(true);
//                }
//
//                result.add(sortProperty);
//            }
//        }
//
//        return result;
//    }
}
