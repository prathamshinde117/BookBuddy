import { BASE_API_URL } from '../common/constants';
import axios from 'axios';


const BASE_URL = BASE_API_URL + '/api/authentication';

class AuthenticationService {

    login(user) {
        return axios.post(BASE_URL + '/signin', user);
    }

    register(user) {
        return axios.post(BASE_URL + '/signup', user);
    }
}

export default new AuthenticationService();
