const toggleSidebar = () => {
    const sidebar = document.querySelector('.sidebar');
    const content = document.querySelector('.content');

    // Toggle 'active' class on sidebar
    sidebar.classList.toggle('active');

    // Check if sidebar has 'active' class
    const isSidebarActive = sidebar.classList.contains('active');

    // Adjust content margin-left based on sidebar state
    if (isSidebarActive) {
        content.style.marginLeft = '20%'; // Adjust margin when sidebar is active
    } else {
        content.style.marginLeft = '0'; // Adjust margin when sidebar is inactive
    }
};

const search = () => {
    // console.log("searching...");
  
    let query = $("#search-input").val();
  
    if (query == "") {
      $(".search-result").hide();
    } else {
      //search
      console.log(query);
  
      //sending request to server
  
      let url = `http://localhost:8283/search/${query}`;
  
      fetch(url)
        .then((response) => {
          return response.json();
        })
        .then((data) => {
          //data......
          // console.log(data);
  
          let text = `<div class='list-group'>`;
  
          data.forEach((contact) => {
            text += `<a href='/user/${contact.cId}/contact' class='list-group-item list-group-item-action'> ${contact.name}  </a>`;
          });
  
          text += `</div>`;
  
          $(".search-result").html(text);
          $(".search-result").show();
        });
    }
  };