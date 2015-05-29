package xebia.tondeuse.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xebia.tondeuse.model.Surface;
import xebia.tondeuse.model.Tondeuse;

public class TondeuseFactoryImpl implements TondeuseFactory {

	public static final char[] ORIENTATION = { 'N', 'E', 'S', 'W' };
	private Surface surface;
	private List<Tondeuse> listeTondeuses = new ArrayList<Tondeuse>();

	@Override
	public void loadFile() {

		BufferedReader br;
		String sCurrentLine;
		try {
			String workingDir = System.getProperty("user.dir");

			br = new BufferedReader(new FileReader(workingDir + "\\param.txt"));

			int index = 0;
			List<String> lignes = new ArrayList<String>();
			while ((sCurrentLine = br.readLine()) != null) {
				if (index == 0) {
					setSurface(new Surface(sCurrentLine));
					index++;
				} else {
					lignes.add(sCurrentLine);
				}

				if (lignes.size() == 2) {
					listeTondeuses.add(new Tondeuse(lignes));
					lignes.clear();
				}
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void startMachines() {
		loadFile();
		for (Tondeuse tondeuse : listeTondeuses) {
			for (char commande : tondeuse.getCommandes()) {
				if (Arrays.asList('G', 'D').contains(commande)) {
					tondeuse.setDirection(getNewDirection(tondeuse.getDirection(), commande));
				} else if ('A' == commande) {
					int newPos;
					switch (tondeuse.getDirection()) {
					case 'N':
						newPos = tondeuse.getyPosition() + 1;
						if (newPos >= 0 && newPos <= surface.getY()) {
							tondeuse.setyPosition(newPos);
						}
						break;
					case 'E':
						newPos = tondeuse.getxPosition() + 1;
						if (newPos >= 0 && newPos <= surface.getX()) {
							tondeuse.setxPosition(newPos);
						}
						break;
					case 'S':
						newPos = tondeuse.getyPosition() - 1;
						if (newPos >= 0 && newPos <= surface.getY()) {
							tondeuse.setyPosition(newPos);
						}
						break;
					case 'W':
						newPos = tondeuse.getxPosition() - 1;
						if (newPos >= 0 && newPos <= surface.getX()) {
							tondeuse.setxPosition(newPos);
						}
						break;
					default:
						break;
					}
				}
			}
			System.out.println(tondeuse);
		}

	}

	@Override
	public char getNewDirection(char currentDir, char rotation) {
		char newDir = currentDir;
		switch (currentDir) {
		case 'N':
			if (rotation == 'G') {
				newDir = 'W';
			} else {
				newDir = 'E';
			}
			break;
		case 'E':
			if (rotation == 'G') {
				newDir = 'N';
			} else {
				newDir = 'S';
			}
			break;
		case 'S':
			if (rotation == 'G') {
				newDir = 'E';
			} else {
				newDir = 'W';
			}
			break;
		case 'W':
			if (rotation == 'G') {
				newDir = 'S';
			} else {
				newDir = 'N';
			}
			break;
		default:
			break;
		}

		return newDir;
	}

	// -----------------------GETTERS && SETTERS
	public List<Tondeuse> getListeTondeuses() {
		return listeTondeuses;
	}

	public void setListeTondeuses(List<Tondeuse> listeTondeuses) {
		this.listeTondeuses = listeTondeuses;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

}
