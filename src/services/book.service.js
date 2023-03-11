import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader } from '../services/base.service';


const API_URL = BASE_API_URL + '/api/book';

class BookService {

    saveBook(book) {
        return axios.post(API_URL, book, {headers: authHeader()});
    }

    deleteBook(book) {
        return axios.delete(API_URL + '/' + book.id, {headers: authHeader()});
    }

    getAllBooks() {
        return axios.get(API_URL);
    }
}

export default new BookService();
