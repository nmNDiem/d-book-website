import React from 'react';
import { Spinner } from 'react-bootstrap';

const MySpinner = () => {
    return (
        <div className="w-100 h-100 d-flex justify-content-center align-items-center">
            <Spinner animation="border" variant="secondary" />
        </div>
    );
};

export default MySpinner;