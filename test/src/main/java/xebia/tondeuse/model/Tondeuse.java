package xebia.tondeuse.model;

import java.util.List;

import xebia.tondeuse.task.CustomException;

public class Tondeuse {

	private int xPosition;
	private int yPosition;
	private char direction;
	private char[] commandes;

	public Tondeuse(List<String> lignes) {
		String[] ligne01 = null;
		if (lignes.size() == 2) {
			ligne01 = lignes.get(0).split(" ");
			if (ligne01.length == 3) {
				setxPosition(Integer.parseInt(ligne01[0]));
				setyPosition(Integer.parseInt(ligne01[1]));
				setDirection(ligne01[2].charAt(0));
			}

			setCommandes(lignes.get(1).toCharArray());
		} else {
			new CustomException("Une tondeuse doit avoir deux lignes comme paramètres");
		}
	}
	
	@Override
	public String toString() {
		return getxPosition()+" "+getyPosition()+" "+getDirection();
	}

	// ----------------GETTERS & SETTERS
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public char[] getCommandes() {
		return commandes;
	}

	public void setCommandes(char[] commandes) {
		this.commandes = commandes;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
