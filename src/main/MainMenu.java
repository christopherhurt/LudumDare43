package main;

public class MainMenu {
    
    public static void init() {
        Game.createScene("mainMenu");
    }
    
    public static void construct() {
        Game.clearScene("mainMenu");
        
        GameObject background = new TexturedGameObject(0, -4, 0, 0, 0, 0, 1, 8, "mainMenuBackground", new Texture("sprites/background.png"));
        Game.addObjectToScene("mainMenu", background);
        
        final float titleHeight = 0.1f;
        final float titleWidth = titleHeight * 144f / 26f;
        final float titleY = 0.25f;
        TexturedGameObject title = new TexturedGameObject((1 - titleWidth) / 2, titleY, 0, 0, 0, 0, titleWidth, titleHeight, "mainMenuTitle", new Texture("menus/titleBanner.png"));
        Game.addObjectToScene("mainMenu", title);
        
        Menu menu = new Menu("mainMenu");
        menu.addButton(new StartButton());
        Game.attachMenuToScene("mainMenu", menu);
        
        Game.setCurrentScene("mainMenu");
    }
    
    private static class StartButton extends TexturedMenuButton {
        
        private static final float HEIGHT = 0.1f;
        private static final float WIDTH = HEIGHT * 66f / 25f;
        private static final float Y = 0.6f;
        
        private static final Texture UNHOVERED_TEX = new Texture("menus/startButtonUnhovered.png");
        private static final Texture HOVERED_TEX = new Texture("menus/startButtonHovered.png");
        private static final Texture CLICKED_TEX = new Texture("menus/startButtonClicked.png");
        
        public StartButton() {
            super((1 - WIDTH) / 2, Y, WIDTH, HEIGHT, UNHOVERED_TEX, HOVERED_TEX, CLICKED_TEX, "startButton");
        }
        
        @Override
        public void update() {
            if(isClicked()) {
                Starter.startThrowScene();
            }
        }
        
    }
    
}
