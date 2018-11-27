package test.vo;

public class TestVo {
    private String name;

    public String getName() {
        return name;
    }

    public TestVo name(String name) {
        this.name = name;
        return this;
    }
}
