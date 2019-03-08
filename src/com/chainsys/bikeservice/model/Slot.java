package com.chainsys.bikeservice.model;

import java.time.LocalDate;

public class Slot {

		private int id;
		private int count;
		private LocalDate date;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "Slot [id=" + id + ", count=" + count + ",date="+ date +"]";
		}
		
}
