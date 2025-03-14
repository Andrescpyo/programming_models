from Calculator import Addition, Subtraction, Multiplication, Division

class CalculatorController:
    def __init__(self, model):

        """
        Initializes the CalculatorController.

        Args:
            model (Calculator): The model for the calculator.
        """

        self.model = model
        self.view = None    # To be assigned from main.py
        self.first_num = None
        self.operation = None
        self.operation_text = ""
        self.operations = {
            "+": Addition(),
            "-": Subtraction(),
            "*": Multiplication(),
            "/": Division()
        }

    def button_click(self, text):

        """
        Handles the button click event.

        Args:
            text (str): The text of the button clicked.
        """

        if text.isdigit() or text == ".":
            self.view.update_display(self.view.display_var.get() + text)
        elif text in self.operations:
            if self.first_num is None:
                self.first_num = float(self.view.display_var.get())
                self.operation = self.operations[text]
                self.operation_text = self.view.display_var.get() + " " + text + " "
                self.view.update_display(self.operation_text)
            else:
                try:
                    second_num = float(self.view.display_var.get().split(" ")[-1])
                    result = self.model.perform_operation(self.operation, self.first_num, second_num)
                    self.view.update_display(str(result))
                    self.first_num = result
                    self.operation = self.operations[text]
                    self.operation_text = str(result) + " " + text + " "
                except:
                    self.view.update_display("Error")
        elif text == "=":
            try:
                second_num = float(self.view.display_var.get().split(" ")[-1])
                result = self.model.perform_operation(self.operation, self.first_num, second_num)
                self.view.update_display(str(result))
                self.first_num = None
                self.operation = None
                self.operation_text = ""
            except Exception as e:
                self.view.update_display("Error")

    def clear_display(self):
        """Clears the display and resets the variables."""
        self.view.clear_display()
        self.first_num = None
        self.operation = None
        self.operation_text = ""

    def backspace(self):
        """Deletes the last character from the display."""
        self.view.backspace()