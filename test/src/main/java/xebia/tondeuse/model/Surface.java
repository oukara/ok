package xebia.tondeuse.model;

import xebia.tondeuse.task.CustomException;

public class Surface {

	private int x;
	private int y;

	public Surface() {
	}

	public Surface(String line) throws Exception {
		String[] line_arr = line.split(" ");

		if (line_arr.length == 2) {
			try {
				setX(Integer.parseInt(line_arr[0]));
				setY(Integer.parseInt(line_arr[1]));
			} catch (Exception e) {
				throw new CustomException("Format des coordoneés pelouse incorrectes !");
			}
		} else {
			throw new CustomException("Coordoneés pelouse incorrectes !");
		}
	}

	// ----------------GETTERS & SETTERS
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
