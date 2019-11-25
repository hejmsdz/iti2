package traffic.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import traffic.ReLogoPatch;

class UserPatch extends ReLogoPatch {
	static laneWidth = 3

	def setColor() {
		def x = getPxcor()
		def y = getPycor()

		if (intersectionType == "p2pIntersection" || intersectionType == "priority") {
			colorIntersection(x, y)
		} else if (intersectionType == "trafficLights") {
			colorTrafficLights(x, y)
		} else if (intersectionType == "roundabout") {
			colorRoundabout(x, y)
		}
	}

	def colorIntersection(int x, int y) {
		if (Math.abs(x) > laneWidth && Math.abs(y) > laneWidth) {
			setPcolor(green())
		} else if ((x == 0 || y == 0) && (x + y).intdiv(2) % 2 == 0) {
			setPcolor(white())
		} else {
			setPcolor(gray() - 3)
		}
	}

	def colorTrafficLights(int x, int y) {
		if (Math.abs(x) > laneWidth && Math.abs(y) > laneWidth) {
			setPcolor(green())
		} else if ((x == 0 || y == 0) && (x + y).intdiv(2) % 2 == 0) {
			setPcolor(white())
		} else {
			setPcolor(gray() - 3)
		}
	}
	
	def changeLights(boolean greenHorizontally ) {
		def x = getPxcor()
		def y = getPycor()
		def pos = laneWidth + 1
		
		if (x == pos && y > 0 && y <= laneWidth) { // Right
			greenHorizontally ? setPcolor(lime()) : setPcolor(red())
		} else if (y < 0 && y >= -laneWidth && x == -pos) { // Left
			greenHorizontally ? setPcolor(lime()) : setPcolor(red())
		} else if (x < 0 && x >= -laneWidth && y == pos) { // Top
			greenHorizontally ? setPcolor(red()) : setPcolor(lime())
		} else if (x > 0 && x <= laneWidth && y == -pos) { // Down
			greenHorizontally ? setPcolor(red()) : setPcolor(lime())
		}
	}

	def colorRoundabout(int x, int y) {
		if (Math.abs(x) > laneWidth && Math.abs(y) > laneWidth && distanceFromCenter(x, y) > 8) {
			setPcolor(green())
		} else if ((x == 0 || y == 0) && (x + y).intdiv(2) % 2 == 0 && distanceFromCenter(x, y) > 5) {
			setPcolor(white())
		} else if (distanceFromCenter(x, y) < 3.5d) {
			setPcolor(green())
		} else {
			setPcolor(gray() - 3)
		} 
	}
	
	private def distanceFromCenter(int x, int y) {
		return Math.sqrt(x*x + y*y)
	}

}
