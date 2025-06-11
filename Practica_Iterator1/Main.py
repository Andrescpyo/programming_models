# main_gui.py

# Importamos la librería Tkinter para la interfaz gráfica.
import tkinter as tk
from tkinter import scrolledtext # Para un área de texto con scroll.

# Importamos las clases de nuestro patrón Iterator.
# El 'Cliente' interactúa con el 'Aggregate' para obtener los 'Iterators'.
from Book import Book
from book_collection import BookCollection

# La clase LibraryApp actúa como el 'Cliente' en el patrón Iterator.
# Es quien utiliza el Aggregate y sus Iteradores para acceder a los datos.
# El cliente no necesita saber cómo la colección almacena los datos,
# solo sabe cómo pedir un iterador y cómo usarlo.
class LibraryApp:
    def __init__(self, master):
        self.master = master
        master.title("Biblioteca - Patrón Iterator")
        master.geometry("600x500")

        # Aquí creamos una instancia del 'Concrete Aggregate'.
        self.library = BookCollection()
        self._load_books() # Cargamos algunos datos de ejemplo.

        self.create_widgets()

    def _load_books(self):
        """Carga algunos libros de ejemplo en la colección (el Aggregate)."""
        self.library.add_book(Book("Cien años de soledad", "Gabriel García Márquez", 1967))
        self.library.add_book(Book("El principito", "Antoine de Saint-Exupéry", 1943))
        self.library.add_book(Book("Don Quijote de la Mancha", "Miguel de Cervantes", 1605))
        self.library.add_book(Book("1984", "George Orwell", 1949))
        self.library.add_book(Book("Rayuela", "Julio Cortázar", 1963))
        self.library.add_book(Book("La Divina Comedia", "Dante Alighieri", 1320))

    def create_widgets(self):
        """Crea los elementos de la interfaz gráfica para el cliente."""
        button_frame = tk.Frame(self.master)
        button_frame.pack(pady=10)

        tk.Label(button_frame, text="Elige el tipo de iteración:").pack(side=tk.LEFT, padx=10)

        # Botones que al ser presionados, solicitan un iterador específico al Aggregate
        # y luego lo utilizan para mostrar los libros.
        btn_normal = tk.Button(button_frame, text="Orden Normal", command=lambda: self.display_books("normal"))
        btn_normal.pack(side=tk.LEFT, padx=5)

        btn_reverse = tk.Button(button_frame, text="Orden Inverso", command=lambda: self.display_books("reverse"))
        btn_reverse.pack(side=tk.LEFT, padx=5)

        btn_author_alpha = tk.Button(button_frame, text="Autor Alfabético", command=lambda: self.display_books("author_alpha"))
        btn_author_alpha.pack(side=tk.LEFT, padx=5)

        self.text_area = scrolledtext.ScrolledText(self.master, wrap=tk.WORD, width=70, height=20)
        self.text_area.pack(pady=10)
        self.text_area.config(state='disabled') # Hacer que el área de texto sea de solo lectura

        # Mostrar los libros por defecto al inicio
        self.display_books("normal")

    def display_books(self, iteration_type):
        """
        Muestra los libros en el área de texto según el tipo de iteración seleccionado.
        Aquí es donde el Cliente interactúa con el Iterador.
        """
        self.text_area.config(state='normal')
        self.text_area.delete(1.0, tk.END)

        iterator = None
        title_message = ""

        # El cliente solicita el iterador apropiado al Aggregate (self.library).
        if iteration_type == "normal":
            # Cuando usamos iter(self.library), Python llama internamente a self.library.__iter__().
            iterator = iter(self.library)
            title_message = "Libros en Orden Normal:"
        elif iteration_type == "reverse":
            # El cliente solicita explícitamente el iterador inverso.
            iterator = self.library.get_reverse_iterator()
            title_message = "Libros en Orden Inverso:"
        elif iteration_type == "author_alpha":
            # El cliente solicita explícitamente el iterador por autor alfabético.
            iterator = self.library.get_author_alphabetical_iterator()
            title_message = "Libros Ordenados por Autor (Alfabético):"

        self.text_area.insert(tk.END, f"{title_message}\n{'='*len(title_message)}\n\n")

        if iterator:
            # Una vez que el cliente tiene el iterador, lo usa para recorrer la colección.
            # Llama a 'next()' en el iterador para obtener el siguiente elemento,
            # sin importar cómo el iterador obtiene ese elemento o cuál es la
            # estructura interna de la colección.
            try:
                while True:
                    book = next(iterator) # Llamada al método __next__ del iterador.
                    self.text_area.insert(tk.END, f"- {book}\n")
            except StopIteration:
                pass # El iterador ha terminado de recorrer todos los elementos.

        self.text_area.config(state='disabled')

if __name__ == "__main__":
    # Punto de entrada de la aplicación GUI.
    root = tk.Tk()
    app = LibraryApp(root)
    root.mainloop()