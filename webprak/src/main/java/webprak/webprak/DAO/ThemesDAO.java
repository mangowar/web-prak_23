package webprak.webprak.DAO;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

import java.util.List;

public abstract class ThemesDAO {
    public abstract void addTheme(themes new_theme);
    public abstract void removeTheme(themes theme);
    public abstract List<topics> getTopics(themes theme);
}
