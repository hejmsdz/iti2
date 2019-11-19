package traffic.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){

		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
		 */
		
		addGlobal("areTrafficLightsGreenHorizontally")

		addGlobal("intersectionType")
		addChooserWL("intersectionType", "Intersection type", ["p2pIntersection", "priority", "trafficLights", "roundabout"], 2)

		addGlobal("acceleration")
		addSliderWL("acceleration", "Car acceleration", 1, 1, 100, 5)
		
		addGlobal("deceleration")
		addSliderWL("deceleration", "Car deceleration", 1, 1, 100, 10)

		addGlobal("maxSpeed")
		addSliderWL("maxSpeed", "Car maximum speed", 1, 1, 100, 5)

		addGlobal("poissonStreamRate")
		addSliderWL("poissonStreamRate", "Car spawn rate", 0.1, 0.1, 2.0, 1.3)

		addGlobal("laneWidth")
		addSliderWL("laneWidth", "Lane width", 1, 1, 8, 2)

		addGlobal("turningThreshold")
		addSliderWL("turningThreshold", "Turning threshold", 0.0, 0.1, 10.0, 0.2)

	}
}
