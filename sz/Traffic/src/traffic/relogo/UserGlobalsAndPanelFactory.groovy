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

		addGlobal("intersectionType")
		addChooserWL("intersectionType", "Intersection type", ["p2pIntersection", "priority", "trafficLights", "roundabout"], 0)

		addGlobal("acceleration")
		addSliderWL("acceleration", "Car acceleration", 1, 1, 100, 10)
		
		addGlobal("deceleration")
		addSliderWL("deceleration", "Car brake deceleration", 1, 1, 100, 75)

		addGlobal("maxSpeed")
		addSliderWL("maxSpeed", "Car maximum speed", 1, 1, 100, 10)

		addGlobal("poissonStreamRate")
		addSliderWL("poissonStreamRate", "Car spawn rate", 0.1, 0.1, 1.0, 0.2)
		
		addMonitorWL("carsOnTheRoad", "Cars on the road now", 5)
		addMonitorWL("numAllCars", "All cars (now and past)", 5)
		addMonitorWL("crashRate", "Crash rate", 5)
		addMonitorWL("meanTravelTime", "Mean travel time (overall)", 5)
		addMonitorWL("meanTravelTimeN", "Mean travel time (north destination)", 5)
		addMonitorWL("meanTravelTimeS", "Mean travel time (south destination)", 5)
		addMonitorWL("meanTravelTimeW", "Mean travel time (west destination)", 5)
		addMonitorWL("meanTravelTimeE", "Mean travel time (east destination)", 5)

	}
}
