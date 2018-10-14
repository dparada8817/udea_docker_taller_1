import { Component, OnInit } from '@angular/core';
import { NameListService } from '../shared/name-list/name-list.service';
import { Person } from '../shared/model/person';

@Component({
  moduleId: module.id,
  selector: 'sd-home',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.css'],
})
export class HomeComponent implements OnInit {

  newName: string = '';
  errorMessage: string;
  persons: Person[] = [];

  constructor(public nameListService: NameListService) {}

  ngOnInit() {
    this.getScientists();
  }

  getScientists() {
    this.nameListService.get()
      .subscribe(
        persons => this.persons = persons,
        error => this.errorMessage = <any>error
      );
  }

  addScientists(): boolean {
   const person = new Person();
   person.nombre = this.newName;
    this.nameListService.save(person)
    .subscribe(
      personSaved => {
        alert('computer scientists ' + personSaved.nombre + ' was saved');
        this.getScientists();
      },
      error => this.errorMessage = <any>error
    );

    this.newName = '';
    return false;
  }

}
