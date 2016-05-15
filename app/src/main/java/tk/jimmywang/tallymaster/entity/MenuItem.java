package tk.jimmywang.tallymaster.entity;

/**
 * Created with Android Studio by 王金 on 2016-05-15 下午12:42.
 *
 * @author 王金
 * @version 1.0
 */
public class MenuItem {

    private Integer menuImage;

    private String menuName;

    private Integer menuFlag;

    public MenuItem(Integer menuImage, String menuName) {
        this.menuImage = menuImage;
        this.menuName = menuName;
    }

    public MenuItem(Integer menuImage, String menuName, Integer menuFlag) {
        this.menuImage = menuImage;
        this.menuName = menuName;
        this.menuFlag = menuFlag;
    }

    public Integer getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(Integer menuFlag) {
        this.menuFlag = menuFlag;
    }

    public Integer getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(Integer menuImage) {
        this.menuImage = menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
