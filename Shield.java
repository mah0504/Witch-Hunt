	package sample;
	
	
	/**
	 * Classe représentant un shield ( bouclier) , un item qui intéragit avec la sorcière
	 * et la rend invincible pendant 3secondes après la collision.
	 */
	
	public class Shield extends Item {
		private boolean used = false;  
				
	/**
	 * Constructeur du shield 
	 * @param x coordonnée x du shield
	 * @param y coordonnée y du shield
	 */
		public Shield(double x, double y) {
			super(x, y);
			this.renderer = new ImageRenderer("shield" ,this);
		}
	
		
		/**
		 * Getter pour avoir la largeur de l'item 
		 * retourne la largeur du shield , un double 
		 */
		@Override
		public double getWidth() {
			return 64;   // 2* radius de 32pixels
		}
	
		/**
		 * Getter pour avoir la hauteur de l'item 
		 * retourne la hauteur du shield , un double 
		 */
		
		@Override
		public double getHeight() {
			return 64; // 2* radius de 32pixel
		}
	
		@Override
		public void tick(double dt) {
	    // pas utilisé pour l'item
			
		}
	
		/**
		 * 
		 * @param  player la sorcière dont on vérifie la collision.
		 * @return booleen, true si le joue intersects avec le shield sinon false
		 */
		@Override
		public boolean intersects(Player player) {
			
			// Vérifie si le joueur entre en collision  en comparant les  distances entre les coordonnées
			// avec le bouclier et que le bouclier n'a pas été utilisé.
			
			return !used
					&& player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
					&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
					&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
					&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
		}
		
		/**
		 * * Gère la collision entre le joueur et le bouclier.
		 * @param player la sorcière (player) 
		 * @param game  le jeu en cours
		 */
	
		@Override
		public void handleCollision(Player player, Game game) {
			if (!used) {
				player.setInvincible(true);
	
				used = true;  // Shield  utilisé après invicible vu qu'il la déclenche. 
			}
		}
	}