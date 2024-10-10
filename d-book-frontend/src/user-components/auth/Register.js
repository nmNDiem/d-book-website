import React, { useState } from "react";
import { Form, Button, Container, Row, Col, Card, Alert } from "react-bootstrap";

const Register = () => {
    const [formData, setFormData] = useState({
        email: "",
        password: "",
        confirmPassword: "",
        fullName: "",
        dob: "",
        title: "",
        phone: "",
        address: "",
        avatar: null
    });

    const [error, setError] = useState("");

    const handleChange = (e) => {
        const { name, value, files } = e.target;
        setFormData({
            ...formData,
            [name]: files ? files[0] : value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (formData.password !== formData.confirmPassword) {
            setError("Mật khẩu và xác nhận mật khẩu không khớp!");
            return;
        }

        setError("");
        console.log("Thông tin đăng ký:", formData);
    };

    const formFields = [
        { label: "Email", name: "email", type: "email", required: true },
        { label: "Mật khẩu", name: "password", type: "password", required: true },
        { label: "Xác nhận mật khẩu", name: "confirmPassword", type: "password", required: true },
        { label: "Họ và tên", name: "fullName", type: "text", required: true },
        { label: "Ngày sinh", name: "dob", type: "date", required: true },
        { label: "Số điện thoại", name: "phone", type: "tel", required: true },
        { label: "Địa chỉ", name: "address", type: "text", required: true }
    ];

    const titles = ["Bạn", "Ông", "Bà", "Anh", "Chị"];

    return (
        <Container className="d-flex align-items-center justify-content-center my-3" style={{ minHeight: "100vh" }}>
            <Row className="w-100 justify-content-center">
                <Col xs={12} md={6} lg={5}>
                    <Card className="shadow custom-card">
                        <Card.Body>
                            <h2 className="text-center mb-4">ĐĂNG KÝ</h2>

                            <Form onSubmit={handleSubmit}>

                                {/* Vòng lặp để tạo các trường form cơ bản */}
                                {formFields.map((field, index) => (
                                    <Form.Group id={field.name} className="mb-2" key={index}>
                                        <Form.Label>{field.label}</Form.Label>
                                        <Form.Control
                                            type={field.type}
                                            name={field.name}
                                            value={formData[field.name]}
                                            onChange={handleChange}
                                            required={field.required}
                                        />
                                    </Form.Group>
                                ))}

                                {/* Dropdown title */}
                                <Form.Group id="title" className="mb-2">
                                    <Form.Label>Bạn muốn được gọi là</Form.Label>
                                    <Form.Control
                                        as="select"
                                        name="title"
                                        value={formData.title}
                                        onChange={handleChange}
                                        required
                                    >
                                        {titles.map((title, index) => (
                                            <option key={index} value={title}>
                                                {title}
                                            </option>
                                        ))}
                                    </Form.Control>
                                </Form.Group>

                                {/* Upload avatar */}
                                <Form.Group id="avatar" className="mb-4">
                                    <Form.Label>Ảnh Đại Diện</Form.Label>
                                    <Form.Control
                                        type="file"
                                        name="avatar"
                                        onChange={handleChange}
                                        accept="image/*"
                                    />
                                </Form.Group>

                                <Button className="custom-button" type="submit">ĐĂNG KÝ</Button>

                                {error && <Alert variant="danger">{error}</Alert>}

                            </Form>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
            <div className="wave"></div>
        </Container>
    );
};

export default Register;
