import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
// import 'rxjs/add/operator/do';  // for debugging
import { Person } from '../model/person';
import { stringify } from '@angular/core/src/util';

@Injectable()
export class NameListService {

  constructor(private http: Http) {}


  get(): Observable<Person[]> {
    return this.http.get('/backend/item')
                    .map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  save(persona: Person): Observable<Person> {
    return this.http.post('/backend/item',  persona).map((res: Response) => res.json())
    .catch(this.handleError);
  }

  /**
    * Handle HTTP error
    */
  private handleError (error: any) {
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }
}

