import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Childapp } from './childapp';

describe('Childapp', () => {
  let component: Childapp;
  let fixture: ComponentFixture<Childapp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Childapp],
    }).compileComponents();

    fixture = TestBed.createComponent(Childapp);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
