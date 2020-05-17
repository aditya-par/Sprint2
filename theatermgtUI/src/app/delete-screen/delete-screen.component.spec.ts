import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteScreenComponent } from './delete-screen.component';

describe('DeleteScreenComponent', () => {
  let component: DeleteScreenComponent;
  let fixture: ComponentFixture<DeleteScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
