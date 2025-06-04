# reverse_book_iterator.py

# Importamos la interfaz abstracta Iterator.
from collections.abc import Iterator

# Otra clase de 'Concrete Iterator'.
# Proporciona una forma alternativa de recorrer la misma colección.
class ReverseBookIterator(Iterator):
    """
    Iterador concreto para recorrer la colección de libros en orden inverso.
    """
    def __init__(self, collection):
        self._collection = collection
        # La posición inicial es el último elemento de la colección para el recorrido inverso.
        self._position = len(collection) - 1

    def __next__(self):
        """
        Retorna el siguiente elemento (en orden inverso) de la colección.
        """
        # Verificamos si aún hay elementos válidos para recorrer (posición no negativa).
        if self._position < 0:
            # Si no quedan elementos, levantamos StopIteration.
            raise StopIteration
        else:
            # Obtenemos el elemento en la posición actual.
            value = self._collection[self._position]
            # Retrocedemos la posición para la próxima llamada.
            self._position -= 1
            return value