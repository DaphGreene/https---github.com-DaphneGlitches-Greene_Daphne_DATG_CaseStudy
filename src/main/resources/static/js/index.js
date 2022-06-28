
const tourDatesAPI = "/tour_dates.json";
const showsTable = document.getElementById("tableBody");
const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');

function deleteTourDate(id) {
  console.log("YEA");
  fetch(`/tour_date/${id}`, { method: 'DELETE', redirect: "manual", headers: { 'X-XSRF-TOKEN': csrfToken }})
  .then( function () {
    location.reload();
  });
}

fetch(tourDatesAPI)
.then( response => response.json() )
.then( data => data.forEach( function( show ) {
   const newRow = document.createElement("tr");
   const newFormat = document.createElement("td");
   newFormat.innerHTML = ">";
   newRow.appendChild(newFormat);
   const newCity = document.createElement("td");
   newCity.innerHTML = show.city;
   newRow.appendChild(newCity);
   const newVenue = document.createElement("td");
   newVenue.innerHTML = show.venue;
   newRow.appendChild(newVenue);
   const newDate = document.createElement("td");
   newDate.innerHTML = show.date;
   newRow.appendChild(newDate);
   const newTickets = document.createElement("td");
   newTickets.innerHTML = `<a href=${show.link}>$${show.preorder}/$${show.door} DOS</a>`;
   newRow.appendChild(newTickets);
   if( document.getElementById('tourActions') ){
       const actions = document.createElement("td");
       actions.innerHTML = `<a href="/tour_date/${show.id}" class="btn btn-primary">Edit</a> <a href="#" class="btn btn-primary" onclick="deleteTourDate(${show.id});">Delete</a>`;
       newRow.appendChild(actions);
   }
   showsTable.appendChild(newRow);
}));
