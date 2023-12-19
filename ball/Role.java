package ball;

//角色
public abstract class Role{
    private String name;
    private String level;
    private String blood;

    public Role(String name) {
        this.name = name;
        this.blood = "100";
    }

    public abstract void drawFight();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
