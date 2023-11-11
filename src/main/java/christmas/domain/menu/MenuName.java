package christmas.domain.menu;

public class MenuName {
    private final String name;

    private MenuName(String name){
        this.name = name;
    }

    public static MenuName from(String name) {
        return new MenuName(name);
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        MenuName otherName = (MenuName) object;
        return name.equals(otherName.name);
     }

    public String getName() {
        return name;
    }
}
