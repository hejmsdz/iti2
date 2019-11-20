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

class UserPatch extends ReLogoPatch{

	def setColor() {
		def x = getPxcor()
		def y = getPycor()

		if (intersectionType == "p2pIntersection") {
			colorP2pIntersection(x, y)
		} else if (intersectionType == "priority") {
			colorPriority(x, y)
		} else if (intersectionType == "trafficLights") {
			colorTrafficLights(x, y)
		}else if (intersectionType == "roundabout") {
			colorRoundabout(x, y)
		} else {
			colorP2pIntersection(x, y)
		}
	}

	def colorP2pIntersection(int x, int y) {
		if (Math.abs(x) > laneWidth && Math.abs(y) > laneWidth) {
			setPcolor(green())
		} else if ((x == 0 || y == 0) && (x + y).intdiv(2) % 2 == 0) {
			setPcolor(white())
		} else {
			setPcolor(gray() - 3)
		}
	}

	def colorPriority(int x, int y) {
		setPcolor(green())
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
	
	def changeLights(boolean greenHorizontally) {
		def x = getPxcor()
		def y = getPycor()
		
		if (x == laneWidth + 1 && y == laneWidth) { // Right
			greenHorizontally ? setPcolor(lime()) : setPcolor(red())
		} else if ((x == -(laneWidth + 1)) && (y == -laneWidth)) { // Left
			greenHorizontally ? setPcolor(lime()) : setPcolor(red())
		} else if ((x == -laneWidth) && (y == laneWidth + 1)) { // Top
			greenHorizontally ? setPcolor(red()) : setPcolor(lime())
		} else if (x == laneWidth && (y == -(laneWidth + 1))) { // Down
			greenHorizontally ? setPcolor(red()) : setPcolor(lime())
		}
	}

	def colorRoundabout(int x, int y) {
		setPcolor(green())
	}

}
