const SHOW_HIDDEN_STATUS = {
  block: "none",
  none: "block",
};

document.addEventListener("DOMContentLoaded", () => {
  const employeesView = document.getElementById("employees-view");
  document
    .getElementsByTagName("button")[0]
    .addEventListener(
      "click",
      () =>
        (employeesView.style.display =
          SHOW_HIDDEN_STATUS[employeesView.style.display])
    );
});
