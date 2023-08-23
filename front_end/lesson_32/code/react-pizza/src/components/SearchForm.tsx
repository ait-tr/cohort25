import React, { useState, useRef } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";

const SearchForm: React.FC = (): JSX.Element => {
    const [localValue, setLocalValue] = useState<string>('');
    const [active, setActive] = useState<boolean>(false);
    const [isFocus, setIsFocus] = useState<boolean>(false);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const inputRef = useRef<HTMLInputElement>(null);

    return (
        <div className={`search ${isFocus ? 'search_focus' : ''}`}>
            <button
                className="button search__button search__button_type_submit"
                type="button"
                onClick={() => setActive(!active)}
            ></button>
            <input
                type="text"
                placeholder="Поиск пиццы..."
                className={`search__input ${active ? 'search__input_active' : ''}`}
            />
            
        </div>
    );
};

export default SearchForm;
