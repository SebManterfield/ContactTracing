package GUI;
// this simple class is used to easily define font styling and allow more re-usability in code
public class Font {
    private String name;
    private int style;
    private int size;

    public Font()
    {
        this.name = "Garamond";
        this.style = 1;
        this.size = 12;
    }
    public Font(int size)
    {
        this.name = "Garamond";
        this.style = 1;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getStyle() {
        return style;
    }

    public int getSize() {
        return size;
    }

}
