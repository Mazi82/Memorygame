import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Visibility extends JButton{
    ImageIcon icon_1;
    ImageIcon icon_2;
    private boolean hidden, no_icon;

///synchronized
    public Visibility(ImageIcon icon_1, ImageIcon icon_2) {
        this.icon_1 = icon_1;
        this.icon_2 = icon_2;
        setSize(100, 100);
        setFocusable(false);
    }

    public void showTile() {
        setIcon(icon_1);
        hidden = false;
    }

    public void hideTile() {
        setIcon(icon_2);
        hidden = true;
    }

    public void setNoIcon() {
        setIcon(null);
        no_icon = true;
    }

    public ImageIcon getImage() {
        return icon_1;
    }

    public boolean isNoIcon() {
        return no_icon;
    }
}
