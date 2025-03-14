# main.py
import tkinter as tk
from Calculator import Calculator
from View import CalculatorGUI
from Controller import CalculatorController

if __name__ == "__main__":
    # Create the main application window
    root = tk.Tk()

    # Instantiate the model (Calculator)
    model = Calculator()

    # Instantiate the controller (CalculatorController), passing the model
    controller = CalculatorController(model)

    # Instantiate the view (CalculatorGUI), passing the main window and the controller
    view = CalculatorGUI(root, controller)

    # Assign the view to the controller so it can update it
    controller.view = view

    # Start the main event loop
    root.mainloop()