import { forwardRef, useEffect, useImperativeHandle, useState } from 'react';
import Book from '../models/book';
import BookService from '../services/book.service';
import { Modal } from 'react-bootstrap';


const BookSave = forwardRef((props, ref) => {

    useImperativeHandle(ref, () => ({
        //interaction with parent
        showBookModal() {
            setTimeout(() => {
                setShow(true);
            }, 0);
        }
    }));

    useEffect(() => {
        setBook(props.book);
    }, [props.book]);

    const [book, setBook] = useState(new Book('', '', 0));
    const [errorMessage, setErrorMessage] = useState('');
    const [submitted, setSubmitted] = useState(false);
    const [show, setShow] = useState(false);

    const saveBook = (e) => {
      e.preventDefault();

      setSubmitted(true);

      if (!book.name || !book.description || !book.price) {
          return;
      }

      BookService.saveBook(book).then(response => {
          //...
          props.onSaved(response.data);
          setShow(false);
          setSubmitted(false);
      }).catch(err => {
          setErrorMessage('Unexpected error occurred.');
          console.log(err);
      });
    };

    //<input name="x" value="y">
    const handleChange = (e) => {
      const {name, value} = e.target;

      setBook((prevState => {
          return {
              ...prevState,
              [name]: value
          };
      }));
    };

    return (
        <Modal show={show}>
            <form onSubmit={(e) => saveBook(e)}
            noValidate
            className={submitted ? 'was-validated' : ''}>

                <div className="modal-header">
                    <h5 className="modal-title">Book Details</h5>
                    <button type="button" className="btn-close" onClick={() => setShow(false)}></button>
                </div>

                <div className="modal-body">

                    {errorMessage &&
                    <div className="alert alert-danger">
                        {errorMessage}
                    </div>
                    }

                    <div className="form-group">
                        <label htmlFor="name">Name: </label>
                        <input
                            type="text"
                            name="name"
                            placeholder="name"
                            className="form-control"
                            value={book.name}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Name is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="name">Author: </label>
                        <input
                            type="text"
                            name="author"
                            placeholder="author"
                            className="form-control"
                            value={book.author}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                           Author is required.
                        </div>
                    </div>


                    <div className="form-group">
                        <label htmlFor="description">Description: </label>
                        <textarea
                            name="description"
                            placeholder="description"
                            className="form-control"
                            value={book.description}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Description is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="price">Price: </label>
                        <input
                            type="number"
                            min="1"
                            step="any"
                            name="price"
                            placeholder="price"
                            className="form-control"
                            value={book.price}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Price is required and should be greater than 0.
                        </div>
                    </div>


                </div>

                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={() => setShow(false)}>Close</button>
                    <button type="submit" className="btn btn-primary">Save Changes</button>
                </div>
            </form>
        </Modal>
    );

});

export {BookSave};
