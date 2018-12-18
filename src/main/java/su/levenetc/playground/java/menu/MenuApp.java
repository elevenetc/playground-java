package su.levenetc.playground.java.menu;

import javafx.application.Platform;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Sample execution to hide window
 * <p>
 * public static void main(String[] args) {
 * <p>
 * System.setProperty("apple.awt.UIElement", "true");
 * <p>
 * SwingUtilities.invokeLater(new Runnable() {
 *
 * @Override public void run() {
 * MenuApp app = new MenuApp();
 * app.addAppToTray();
 * }
 * });
 * }
 */
public class MenuApp {

    public static final HashMap<RenderingHints.Key, Object> RenderingProperties = new HashMap<>();

    static {
        RenderingProperties.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        RenderingProperties.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        RenderingProperties.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        RenderingProperties.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    }

    private TrayIcon trayIcon;
    private String title;
    private List<String> items;

    private MenuApp(String title) {

        this.title = Objects.requireNonNull(title);
    }

    public BufferedImage textToImage(String Text, Font f, float Size) {
        f = f.deriveFont(Size);

        FontRenderContext frc = new FontRenderContext(null, true, true);

        LineMetrics lm = f.getLineMetrics(Text, frc);
        Rectangle2D r2d = f.getStringBounds(Text, frc);
        BufferedImage img = new BufferedImage((int) Math.ceil(r2d.getWidth()), (int) Math.ceil(r2d.getHeight()), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHints(RenderingProperties);
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.setColor(Color.BLACK);

        g2d.clearRect(0, 0, img.getWidth(), img.getHeight());
        g2d.setFont(f);
        g2d.drawString(Text, 0, lm.getAscent());
        g2d.dispose();

        return img;
    }

    public void show() {
        try {
            java.awt.Toolkit.getDefaultToolkit();

            if (!java.awt.SystemTray.isSupported()) {
                System.out.println("No system tray support, application exiting.");
                Platform.exit();
            }

            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();

            trayIcon = new TrayIcon(iconImage(title));

            java.awt.MenuItem openItem = new java.awt.MenuItem("hello, world");
            java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
            openItem.setFont(boldFont);

            java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");
            exitItem.addActionListener(event -> {
                Platform.exit();
                tray.remove(trayIcon);
            });

            openItem.addActionListener(event -> {

            });

            // setup the menu for the application.
            final java.awt.PopupMenu menu = new java.awt.PopupMenu();

            for (String item : items) {
                menu.add(item);
            }

            trayIcon.setPopupMenu(menu);
            trayIcon.setImageAutoSize(true);

            tray.add(trayIcon);
        } catch (Throwable e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
    }

    private BufferedImage iconImage(String text) {
        return textToImage(text, java.awt.Font.decode(null), 13);
    }

    private void setItems(List<String> items) {

        this.items = items;
    }

    public static class Builder {

        private List<String> items = new LinkedList<>();
        private String title;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder item(String item) {
            items.add(item);
            return this;
        }

        public MenuApp build() {
            MenuApp result = new MenuApp(title);
            result.setItems(items);
            return result;
        }

    }
}
