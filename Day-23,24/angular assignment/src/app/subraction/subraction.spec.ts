import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Subraction } from './subraction';

describe('Subraction', () => {
  let component: Subraction;
  let fixture: ComponentFixture<Subraction>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Subraction],
    }).compileComponents();

    fixture = TestBed.createComponent(Subraction);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
