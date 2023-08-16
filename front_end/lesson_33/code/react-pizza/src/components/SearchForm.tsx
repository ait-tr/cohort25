import React, { useState, useRef } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { onClickCategory } from "../redux/slices/filterSlice";
import { onChangeSearch } from "../redux/slices/searchSlice";

const SearchForm: React.FC = (): JSX.Element => {
    const [localValue, setLocalValue] = useState<string>('');
    const [active, setActive] = useState<boolean>(false);
    const [isFocus, setIsFocus] = useState<boolean>(false);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const inputRef = useRef<HTMLInputElement>(null);

    const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setLocalValue(e.target.value);
        e.target.value ? navigate('/search') : navigate('/');
        dispatch(onClickCategory(0));
    }

    const onClickClear = () => {
        dispatch(onChangeSearch(''));
        setLocalValue('');
        // NullPointerException (from Java)
        // Ставим фокус на input элемент
        inputRef.current?.focus();
        navigate('/');
    }

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
                onFocus={() => setIsFocus(true)}
                onBlur={() => setIsFocus(false)}
                onChange={onChange}
                value={localValue}
                ref={inputRef}
            />
            <button
                className={`button search__button search__button_type_clear
                            ${localValue ? 'search__button_visibled' : ''}`}
                onClick={onClickClear}
            ></button>
        </div>
    );
};

export default SearchForm;
