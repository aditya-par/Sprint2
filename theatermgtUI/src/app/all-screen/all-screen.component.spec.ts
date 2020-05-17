import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllScreenComponent } from './all-screen.component';

describe('AllScreenComponent', () => {
  let component: AllScreenComponent;
  let fixture: ComponentFixture<AllScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
