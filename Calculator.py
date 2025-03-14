from abc import ABC, abstractmethod

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

# Ejemplo de uso:
calculator = Calculator()
addition = Addition()
subtraction = Subtraction()
division = Division()
multiplication = Multiplication()

print(calculator.perform_operation(addition, 5, 3))  # Imprime 8
print(calculator.perform_operation(subtraction, 5, 3)) # Imprime 2
print(calculator.perform_operation(division, 10, 2)) # Imprime 5.0
print(calculator.perform_operation(multiplication, 4, 6)) # Imprime 24

