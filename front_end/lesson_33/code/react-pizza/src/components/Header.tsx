import React from "react";
import Logo from "./Logo";

const Header: React.FC = (): JSX.Element => {
    return (
        <header className="header">
            <div className="header__row">
                <Logo className="header__logo" />
            </div>
        </header>
    );
};

export default Header;
