# book.py

# Esta clase representa un 'Elemento' o 'Ítem' en nuestra colección.
# Aunque no es parte directa del patrón Iterator en sí, es el objeto
# sobre el cual el iterador operará y que será contenido en el Aggregate.
class Book:
    def __init__(self, title, author, year):
        self.title = title
        self.author = author
        self.year = year

    def __str__(self):
        return f'"{self.title}" por {self.author} ({self.year})'

    def __repr__(self):
        # Útil para representaciones en listas o depuración.
        return self.__str__()