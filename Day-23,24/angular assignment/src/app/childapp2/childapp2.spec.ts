import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Childapp2 } from './childapp2';

describe('Childapp2', () => {
  let component: Childapp2;
  let fixture: ComponentFixture<Childapp2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Childapp2],
    }).compileComponents();

    fixture = TestBed.createComponent(Childapp2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
