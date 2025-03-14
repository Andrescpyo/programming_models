import tkinter as tk
from tkinter import ttk

class CalculatorGUI:
    def __init__(self, root, controller):

        """
        Initializes the CalculatorGUI.

        Args:
            root (tk.Tk): The main window of the application.
            controller (CalculatorController): The controller for the calculator.
        """

        self.root = root
        self.root.title("Calculadora")
        self.controller = controller

        # Variable to store the text displayed on the screen
        self.display_var = tk.StringVar()
        # Text input to display the operation and result
        self.display_entry = ttk.Entry(root, textvariable=self.display_var, state="readonly", justify="right", width=35, font=("Arial", 15))
        self.display_entry.grid(row=0, column=0, columnspan=6, padx=2, pady=2)

        # Definition of the buttons for the calculator
        buttons = [
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        ]

        # create and positioning of the buttons
        row_val = 1
        col_val = 0
        for button_text in buttons:
            ttk.Button(root, text=button_text, command=lambda text=button_text: self.controller.button_click(text)).grid(row=row_val, column=col_val)
            col_val += 1
            if col_val > 3:
                col_val = 0
                row_val += 1

        # Control Buttons (clear and backspace)
        ttk.Button(root, text="C", command=self.controller.clear_display).grid(row=1, column=5)
        ttk.Button(root, text="←", command=self.controller.backspace).grid(row=2, column=5)

    def update_display(self, text):

        """
        Updates the display entry with the given text.

        Args:
            text (str): The text to display.
        """
        
        self.display_var.set(text)

    def clear_display(self):
        """Clears the display."""
        self.display_var.set("")

    def backspace(self):
        """Deletes the last character from the display."""
        self.display_var.set(self.display_var.get()[:-1])