import { useEffect, useRef, useState } from 'react';
import BookService from '../../services/book.service';
import { BookSave } from '../../components/book-save';
import Book from '../../models/book';
import { BookDelete } from '../../components/book-delete';


const AdminPage = () => {

    const [bookList, setBookList] = useState([]);
    const [selectedBook, setSelectedBook] = useState(new Book('', '',' ', 0));
    const [errorMessage, setErrorMessage] = useState('');

    const saveComponent = useRef();
    const deleteComponent = useRef();

    useEffect(() => {
        BookService.getAllBooks().then((response) => {
            setBookList(response.data);
        });
    }, []);

    const createBookRequest = () => {
        setSelectedBook(new Book('', '',' ', 0));
        saveComponent.current?.showBookModal();
    };

    const editBookRequest = (item) => {
      setSelectedBook(Object.assign({}, item));
        saveComponent.current?.showBookModal();
    };

    const deleteBookRequest = (book) => {
        setSelectedBook(book);
        deleteComponent.current?.showDeleteModal();
    };

    const saveBookWatcher = (book) => {
        let itemIndex = bookList.findIndex(item => item.id === book.id);

        if (itemIndex !== -1) {
            const newList = bookList.map((item) => {
                if (item.id === book.id) {
                    return book;
                }
                return item;
            });
            setBookList(newList);
        } else {
            const newList = bookList.concat(book);
            setBookList(newList);
        }
    };

    const deleteBook = () => {
      BookService.deleteBook(selectedBook).then(_ => {
          setBookList(bookList.filter(x => x.id !== selectedBook.id));
      }).catch(err => {
          setErrorMessage('Unexpected error occurred.');
          console.log(err);
      });
    };

    return (
        <div>
            <div className="container">
                <div className="pt-5">

                    {errorMessage &&
                    <div className="alert alert-danger">
                        {errorMessage}
                    </div>
                    }

                    <div className="card">
                        <div className="card-header">

                            <div className="row">
                                <div className="col-6">
                                    <h3>All Books</h3>
                                </div>

                                <div className="col-6 text-end">
                                    <button className="btn btn-primary" onClick={() => createBookRequest()}>
                                        Create Book
                                    </button>
                                </div>

                            </div>

                        </div>
                        <div className="card-body">
                            <table className="table table-striped">

                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>

                                {bookList.map((item, ind) =>
                                    <tr key={item.id}>
                                        <th scope="row">{ind + 1}</th>
                                        <td>{item.name}</td>
                                        <td>{item.author}</td>
                                        <td>{`$ ${item.price}`}</td>
                                        <td>{new Date(item.createTime).toLocaleDateString()}</td>
                                        <td>
                                            <button className="btn btn-primary me-1" onClick={() => editBookRequest(item)}>
                                                Edit
                                            </button>
                                            <button className="btn btn-danger" onClick={() => deleteBookRequest(item)}>
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                )}


                                </tbody>

                            </table>
                        </div>
                    </div>

                </div>
            </div>

            <BookSave ref={saveComponent} book={selectedBook} onSaved={(p) => saveBookWatcher(p)}/>
            <BookDelete ref={deleteComponent} onConfirmed={() => deleteBook()}/>

        </div>
    );
};

export {AdminPage};
