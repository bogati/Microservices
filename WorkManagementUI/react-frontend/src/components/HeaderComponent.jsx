import React, { Component } from "react";

class HeaderComponent extends Component {
  render() {
    return (
      <div>
        <header className="header">
          <nav className="text-center">
            <div>
              <a href="http://localhost:3000" className="navbar-brand">
                Jump Jet Auto JobCard Board
              </a>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;
