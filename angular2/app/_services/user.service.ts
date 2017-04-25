import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { User }           from '../_models/user';
import { Injectable }     from '@angular/core';
import {Pipe, PipeTransform} from '@angular/core';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class UserService {
     // Resolve HTTP using the constructor
     constructor (private http: Http) {}
     // private instance variable to hold base url
     private usersUrl = 'http://localhost:8080/Projet_1_Blog/api/getallusers';
     private addUserUrl = 'http://localhost:8080/Projet_1_Blog/api/addUsers';
     private userUrl = 'http://localhost:8080/Projet_1_Blog/api/user';
     
     // Fetch all existing users
     getUsers() : Observable<User[]>{
         // ...using get request
         return this.http.get(this.userUrl)
                        // ...and calling .json() on the response to return data
                         .map((res:Response) => res.json())
                         //...errors if any
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
                         //console.log(response);       
     }
     // Add a new user
    addUser (body: Object): Observable<User[]> {
        let bodyString = JSON.stringify(body); // Stringify payload
        let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options = new RequestOptions({ headers: headers }); // Create a request option

        return this.http.post(this.addUserUrl, body, options) // ...using post request
                         .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
    }   
    // Update a user
    updateUser (body: Object): Observable<User[]> {
        let bodyString = JSON.stringify(body); // Stringify payload
        let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options = new RequestOptions({ headers: headers }); // Create a request option

        return this.http.put(`${this.usersUrl}/${body['id']}`, body, options) // ...using put request
                         .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
    }   
    // Delete a user
    removeUser (id:string): Observable<User[]> {
        return this.http.delete(`${this.usersUrl}/${id}`) // ...using put request
                         .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
    }   
}