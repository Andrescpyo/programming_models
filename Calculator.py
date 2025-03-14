from abc import ABC, abstractmethod

# Definition of the interface for arithmetic operations
class Operation(ABC):
    @abstractmethod
    def execute(self, a, b):
        """Abstract method defining the operation to be performed."""
        pass

# Concrete implementations of the operations
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

# Main calculator class, uses the defined operations
class Calculator:
    def perform_operation(self, operation, a, b):
        """Executes a given operation with two operands."""
        return operation.execute(a, b)