from abc import ABC, abstractmethod
import tkinter as tk
from tkinter import ttk

class Operation(ABC):
    @abstractmethod
    def execute(self, a, b):
        pass

class Addition(Operation):
    def execute(self, a, b):
        return a + b
    
class Subtraction(Operation):
    def execute(self, a, b):
        return a - b
    
class Division(Operation):
    def execute(self, a, b):
        return a / b

class Multiplication(Operation):
    def execute(self, a, b):
        return a * b

class Calculator:
    def perform_operation(self, operation, a, b):
        return operation.execute(a, b)

class CalculatorGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Calculadora")

        self.calculator = Calculator()
        self.operations = {
            "+": Addition(),
            "-": Subtraction(),
            "/": Division(),
            "*": Multiplication()
        }

        self.display_var = tk.StringVar()
        self.display_entry = ttk.Entry(root, textvariable=self.display_var, state="readonly", justify="right", width=20, font=("Arial", 20))
        self.display_entry.grid(row=0, column=0, columnspan=5)

        buttons = [
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        ]

        row_val = 1
        col_val = 0
        for button_text in buttons:
            ttk.Button(root, text=button_text, command=lambda text=button_text: self.button_click(text)).grid(row=row_val, column=col_val)
            col_val += 1
            if col_val > 3:
                col_val = 0
                row_val += 1

        ttk.Button(root, text="C", command=self.clear_display).grid(row=1, column=5)
        ttk.Button(root, text="←", command=self.backspace).grid(row=2, column=5)

        self.first_num = None
        self.operation = None
        self.operation_text = ""

    def button_click(self, text):
        if text.isdigit() or text == ".":
            self.display_var.set(self.display_var.get() + text)
        elif text in self.operations:
            if self.first_num is None:
                self.first_num = float(self.display_var.get())
                self.operation = self.operations[text]
                self.operation_text = self.display_var.get() + " " + text + " "
                self.display_var.set(self.operation_text)
            else:
                try:
                    second_num = float(self.display_var.get().split(" ")[-1])
                    result = self.calculator.perform_operation(self.operation, self.first_num, second_num)
                    self.display_var.set(str(result))
                    self.first_num = result
                    self.operation = self.operations[text]
                    self.operation_text = str(result) + " " + text + " "
                except:
                    self.display_var.set("Error")

        elif text == "=":
            try:
                second_num = float(self.display_var.get().split(" ")[-1])
                result = self.calculator.perform_operation(self.operation, self.first_num, second_num)
                self.display_var.set(self.operation_text + str(second_num) + " = " + str(result))
                self.first_num = None
                self.operation = None
                self.operation_text = ""
            except Exception as e:
                self.display_var.set("Error")

    def clear_display(self):
        self.display_var.set("")
        self.first_num = None
        self.operation = None
        self.operation_text = ""

    def backspace(self):
        self.display_var.set(self.display_var.get()[:-1])

if __name__ == "__main__":
    root = tk.Tk()
    app = CalculatorGUI(root)
    root.mainloop()