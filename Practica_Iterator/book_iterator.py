# book_iterator.py

# collections.abc.Iterator es la 'Interfaz Iterator' abstracta en Python.
# Al heredar de ella, nos aseguramos de implementar los métodos necesarios
# para ser un iterador (principalmente __next__).
from collections.abc import Iterator

# La clase BookIterator es un 'Concrete Iterator' (Iterador Concreto).
# Implementa la 'Interfaz Iterator' y define el algoritmo para recorrer
# la colección en un orden específico (normal, de principio a fin).
class BookIterator(Iterator):
    """
    Iterador concreto para recorrer la colección de libros en orden normal.
    Mantiene la posición actual en la colección durante el recorrido.
    """
    def __init__(self, collection):
        # El iterador necesita una referencia a la colección sobre la cual operará.
        # Es importante no modificar la colección directamente si no es necesario.
        self._collection = collection
        # La 'posición' actual en el recorrido. Es el estado interno del iterador.
        self._position = 0

    def __next__(self):
        """
        Retorna el siguiente elemento de la colección.
        Este es el método principal de la 'Interfaz Iterator'.
        """
        try:
            # Obtenemos el elemento en la posición actual.
            value = self._collection[self._position]
            # Avanzamos la posición para la próxima llamada.
            self._position += 1
            return value
        except IndexError:
            # Cuando no hay más elementos para recorrer, se levanta StopIteration.
            # Esto es lo que le indica a los bucles 'for' en Python que terminen.
            raise StopIteration