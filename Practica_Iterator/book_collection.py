# book_collection.py

# Importamos los iteradores concretos que esta colección puede proporcionar.
# Esto demuestra que el Aggregate es responsable de crear (instanciar)
# los iteradores adecuados para sí mismo.
from book_iterator import BookIterator
from reverse_book_iterator import ReverseBookIterator
from author_alphabetical_iterator import AuthorAlphabeticalIterator

# La clase BookCollection es el 'Concrete Aggregate' (Agregado Concreto).
# Es la colección de objetos que queremos recorrer.
# Su principal responsabilidad es proporcionar una interfaz para crear objetos Iterator.
class BookCollection:
    def __init__(self):
        # La representación interna de la colección (una lista en este caso).
        # El patrón Iterator nos permite recorrerla sin exponer esta lista directamente.
        self._books = []

    def add_book(self, book):
        # Método para añadir elementos a la colección.
        self._books.append(book)

    # Este método mágico __iter__ es crucial para el patrón Iterator en Python.
    # Es la implementación del método 'createIterator()' del patrón.
    # Permite que las instancias de BookCollection sean iterables directamente
    # en bucles 'for', proporcionando un iterador por defecto (el normal).
    def __iter__(self):
        """
        Retorna el iterador por defecto (normal) para la colección.
        Esta es la implementación del método 'createIterator()' del patrón Iterator.
        """
        # Devolvemos una nueva instancia de un Concrete Iterator.
        return BookIterator(self._books)

    def get_reverse_iterator(self):
        """
        Retorna un iterador inverso para la colección.
        Esto demuestra que un Aggregate puede ofrecer múltiples tipos de iteradores,
        cada uno para una forma diferente de recorrido.
        """
        return ReverseBookIterator(self._books)

    def get_author_alphabetical_iterator(self):
        """
        Retorna un iterador que ordena los libros por autor alfabéticamente.
        Otro ejemplo de cómo el Aggregate puede proporcionar iteradores especializados.
        """
        return AuthorAlphabeticalIterator(self._books)

    def __len__(self):
        # Método para obtener la longitud de la colección, útil para el iterador inverso.
        return len(self._books)