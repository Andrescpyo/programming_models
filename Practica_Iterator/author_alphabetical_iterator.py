# author_alphabetical_iterator.py

# Importamos la interfaz abstracta Iterator.
from collections.abc import Iterator

# Otro 'Concrete Iterator' que ofrece una vista ordenada de la colección.
# Esto demuestra que el iterador puede aplicar lógica de ordenamiento o filtrado
# sin que el Aggregate (la colección) necesite conocer esos detalles.
class AuthorAlphabeticalIterator(Iterator):
    """
    Iterador concreto que recorre los libros ordenados alfabéticamente por el autor.
    """
    def __init__(self, collection):
        # Para ordenar, es mejor trabajar con una copia de la colección
        # para no alterar el orden original de la colección subyacente.
        # sorted() crea una nueva lista.
        # key=lambda book: book.author.lower() especifica que se ordene por el
        # atributo 'author' de cada libro, convirtiéndolo a minúsculas para
        # un ordenamiento insensible a mayúsculas/minúsculas.
        self._sorted_books = sorted(collection, key=lambda book: book.author.lower())
        self._position = 0

    def __next__(self):
        """
        Retorna el siguiente libro en orden alfabético por autor.
        """
        try:
            # Obtenemos el elemento de la lista ya ordenada.
            value = self._sorted_books[self._position]
            self._position += 1
            return value
        except IndexError:
            raise StopIteration